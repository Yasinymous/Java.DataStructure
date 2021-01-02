public class AVLNode {
    private int data = 0;
    private String key = null;
    private String originalData = null;
    private AVLNode leftChild = null;
    private AVLNode rightChild = null;
    private int height = 0;

    public AVLNode (String key, String originalData){
        this.key = key;
        this.originalData = originalData;
        leftChild = null;
        rightChild = null;
        height = 0;
        data = 0;
    }
    public int getData(){
        data++;
        return data;
    }

    public String getKey(){
        return key;
    }

    public String getOriginalData(){
        return originalData;
    }

    public AVLNode getLeftChild (){
        return leftChild;
    }

    public void setLeftChild (AVLNode n){
        leftChild = n;
    }

    public AVLNode getRightChild (){
        return rightChild;
    }

    public void setRightChild (AVLNode n){
        rightChild = n;
    }

    public int getHeight (){
        return height;
    }

    public void setHeight (int h){
        height = h;
    }
}