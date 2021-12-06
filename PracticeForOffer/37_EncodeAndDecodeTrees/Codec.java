import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    /*
    public static String serialize(TreeNode root) {
        Queue<TreeNode> fringe = new ArrayDeque<>();
//        int terminateIndex = 0;
//        if (root == null) {
//            terminateIndex = -1;
//        }
        boolean allNullFlag = (root == null);
        int layerNumber = 1;
        StringBuilder treeString = new StringBuilder();
        treeString.append("[");
        fringe.add(root);
        while (!fringe.isEmpty()) {
            if (allNullFlag) {
                break;
            }
            allNullFlag = true;
            for (int i = 0; i < layerNumber; i++) {
                TreeNode presentNode = fringe.poll();
                if (presentNode == null) {
                    treeString.append("null,");
                    fringe.add(null);
                    fringe.add(null);
                } else {
                    treeString.append(presentNode.val).append(",");
                    fringe.add(presentNode.left);
                    fringe.add(presentNode.right);
                    if (presentNode.left == null || presentNode.right == null) {
                        allNullFlag = false;
                    }
                }
            }
            layerNumber *= 2;
        }
        if (treeString.length() > 1) {
            treeString.deleteCharAt(treeString.length() - 1);
        }
        treeString.append("]");
        return treeString.toString();
    }
     */

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        TreeNode[] nodeArray = new TreeNode[8];
        int nodeNumber = 1;
        int index = 0;
        nodeArray[0] = root;
        boolean allNullFlag = false;
        while (!allNullFlag) {
            allNullFlag = true;
            int endNumber = index + nodeNumber;
            while (index < endNumber) {
                if (2 * index + 2 >= nodeArray.length) {
                    nodeArray = resize(nodeArray, 3 * nodeArray.length);
                }
                if (nodeArray[index] == null) {
                    nodeArray[2 * index + 1] = null;
                    nodeArray[2 * index + 2] = null;
                } else {
                    allNullFlag = false;
                    nodeArray[2 * index + 1] = nodeArray[index].left;
                    nodeArray[2 * index + 2] = nodeArray[index].right;
                }
                index += 1;
            }
            nodeNumber *= 2;
        }
        StringBuilder resultString = new StringBuilder();
        resultString.append('[');
        for (int i = 0; i < index - nodeNumber/2; i++) {
            if (nodeArray[i] == null) {
                resultString.append("null");
            } else {
                resultString.append(nodeArray[i].val);
            }
            if (i + 1 < index - nodeNumber/2) {
                resultString.append(',');
            }
        }
        resultString.append(']');
        return resultString.toString();
    }

    // Decodes your encoded data to tree.
    /*
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        int ptr = 0;
        TreeNode root;
        TreeNode parentNode = new TreeNode(-1);
        Queue<TreeNode> fringe = new ArrayDeque<>();
        while (data.charAt(ptr) != ']') {
            int presentNum = 0;
            ptr += 1;
            while (data.charAt(ptr) >= '0' && data.charAt(ptr) <= '9') {
                presentNum = presentNum * 10 + (data.charAt(ptr) - '0');
                ptr += 1;
            }
            TreeNode presentNode = new TreeNode(presentNum);
            if (fringe.isEmpty()) {
                fringe.add(presentNode);
                root = presentNode;
                parentNode = presentNode;
            } else {
                if (parentNode.left == null) {
                    parentNode.left = presentNode;
                } else {
                    parentNode.right = presentNode;
                    parentNode = fringe.poll();
                }
                fringe.add(parentNode);
            }
        }
        return null;
    }*/

    public static TreeNode deserialize(String data) {
        int arraySize = 0;
        int stringPtr = 0;
        TreeNode[] nodeArray = new TreeNode[8];
        while (data.charAt(stringPtr) != ']') {
            stringPtr += 1;
            if (data.charAt(stringPtr) == ']') {
                return null;
            } else if (data.charAt(stringPtr) == 'n') {
                nodeArray[arraySize] = null;
                stringPtr += 4;
            } else {
                int presentNum = 0;
                boolean negativeFlag = false;
                if (data.charAt(stringPtr) == '-') {
                    negativeFlag = true;
                    stringPtr += 1;
                }
                while (data.charAt(stringPtr) >= '0' && data.charAt(stringPtr) <= '9') {
                    presentNum = presentNum * 10 + (data.charAt(stringPtr) - '0');
                    stringPtr += 1;
                }
                if (negativeFlag) {
                    presentNum *= -1 ;
                }
                TreeNode presentNode = new TreeNode(presentNum);
                nodeArray[arraySize] = presentNode;
            }
            arraySize += 1;
            if (arraySize >= nodeArray.length) {
                nodeArray = resize(nodeArray, 2 * nodeArray.length);
            }
        }
        int index = 0;
        while(true) {
            if (nodeArray[index] != null) {
                if (2 * index + 1 >= arraySize) {
                    break;
                }
                nodeArray[index].left = nodeArray[2 * index + 1];
                if (2 * index + 2 >= arraySize) {
                    break;
                }
                nodeArray[index].right = nodeArray[2 * index + 2];
            }
            index += 1;
        }
        return nodeArray[0];
    }

    private static TreeNode[] resize(TreeNode[] originalList, int capacity) {
        TreeNode[] newList = new TreeNode[capacity];
        System.arraycopy(originalList, 0, newList, 0, originalList.length);
        return newList;
    }

    public static void main(String[] args) {
        TreeNode testNode = deserialize("[-1,0,1]");
        String testString = serialize(testNode);
        System.out.println(testString);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));n