public class AVLTree {

    private AVLNode root = null;
    private int size = 0;

    public AVLTree (){
        root = null;
        size = 0;
    }


    public void ekle(String key){
        root = ekle(key.toLowerCase(), key, root);
    }
    private AVLNode ekle(String key, String originalData, AVLNode node){
        if (node == null){
            node = new AVLNode(key, originalData);
            size++;
            node.getData();
            return node;
        }
        else{
            if (key.compareTo (node.getKey()) < 0){
                node.setLeftChild (ekle(key, originalData, node.getLeftChild ()));
                if (height (node.getLeftChild ()) - height (node.getRightChild ()) == 2){
                    if (key.compareTo ((node.getLeftChild ()).getKey ()) < 0)
                        node = rotateWithLeft (node);
                    else
                        node = doubleWithLeft (node);
                }
            }
            else{
                if (key.compareTo (node.getKey ()) > 0){
                    node.setRightChild (ekle (key, originalData, node.getRightChild ()));
                    if (height (node.getRightChild ()) - height (node.getLeftChild ()) == 2){
                        if (key.compareTo ((node.getRightChild ()).getKey ()) > 0)
                            node = rotateWithRight (node);
                        else
                            node = doubleWithRight (node);
                    }
                }
            }
        }
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        return node;
    }

    public void sil(String key) {
        AVLNode parent = null;
        AVLNode target = null;
        AVLNode node = root;
        while (target == null && node != null){
            if (key.compareTo(node.getKey()) < 0){
                parent = node;
                node = node.getLeftChild ();
            }
            else if (key.compareTo(node.getKey()) > 0){
                parent = node;
                node = node.getRightChild ();
            }
            else{
                target = node;
            }
        }
        if (target == null){
            System.out.println("Bulunmadi...");
            return;
        }
        if (target.getLeftChild() == null && target.getRightChild() == null){
            if (parent.getLeftChild() == target) {
                parent.setLeftChild(null);
            }
            else {
                parent.setRightChild(null);
            }
        }
        else if( (target.getLeftChild() == null)  && (target.getRightChild() != null) ){
            parent.setRightChild(target.getRightChild());
        }
        else if( (target.getLeftChild() != null)  && (target.getRightChild() == null) ){
            parent.setLeftChild(target.getLeftChild());
        }

        //(AVLNode node, AVLNode parent, AVLNode target)
        else{    AVLNode a = target.getLeftChild();
                AVLNode b = target.getRightChild();
                //murat parent
             //serkan target
            if (parent.getLeftChild() == target) {
                parent.setLeftChild(a);
                parent.getLeftChild().setLeftChild(b);
            }
            else {
                parent.setRightChild(b);
                parent.getRightChild().setRightChild(a);

                System.out.println("girdi4");
            }
        }
        System.out.println(key+" : Silindi...");
        size--;
    }




    public boolean ata(String key){
        return ata (key, root);
    }

    private boolean ata (String key, AVLNode node){
        if (search(key) == false) {
            System.out.println(key+" : Bulunumadi...");
            return false;
        }
        if (key.compareTo (node.getKey ()) < 0) {
            System.out.print(node.getOriginalData()+"->");
            return ata(key, node.getLeftChild());
        }
        if (key.compareTo (node.getKey ()) > 0) {
            System.out.print(node.getOriginalData()+"->");
            return ata(key, node.getRightChild());
        }
        System.out.println(key);
        return true;
    }



    public void inorder(){
        inorder(root);
    }
    private void inorder(AVLNode node) {
        if (node != null)
        {
            inorder(node.getLeftChild());
            System.out.print(node.getOriginalData() +" ");
            inorder(node.getRightChild());
        }
    }

    public void preorder() {
        preorder(root);
    }
    private void preorder(AVLNode node) {
        if (node != null)
        {
            System.out.print(node.getOriginalData() +" ");
            preorder(node.getLeftChild());
            preorder(node.getRightChild());
        }
    }

    public void postorder() {
        postorder(root);
    }
    private void postorder(AVLNode node) {
        if (node != null)
        {
            postorder(node.getLeftChild());
            postorder(node.getRightChild());
            System.out.print(node.getOriginalData() +" ");
        }
    }

    public int countNodes() {
        return countNodes(root);
    }
    private int countNodes(AVLNode node) {
        if (node != null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(node.getLeftChild());
            l += countNodes(node.getRightChild());
            return l;
        }
    }

    public boolean search(String key){
        //return search (key, root);
        boolean control = search(key, root);

        return control;
    }

    private boolean search (String key, AVLNode node){
        if (node == null) {
            return false;
        }
        if (key.compareTo (node.getKey ()) < 0) {
            return search(key, node.getLeftChild());
        }
        if (key.compareTo (node.getKey ()) > 0) {
            return search(key, node.getRightChild());
        }
        return true;
    }


    public AVLNode root(){
        return root;
    }

    public int size(){
        return size;
    }

    public int height(){
        return height (root);
    }

    private int height(AVLNode node){
        if (node == null)
            return -1;
        return node.getHeight ();
    }

    public boolean isEmpty (){
        return (size == 0);
    }

    private AVLNode rotateWithLeft (AVLNode node){
        AVLNode newNode = node.getLeftChild ();
        node.setLeftChild (newNode.getRightChild ());
        newNode.setRightChild (node);
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        newNode.setHeight (max (height (newNode.getLeftChild ()), node.getHeight ()) + 1);
        return newNode;
    }


    private AVLNode rotateWithRight (AVLNode node){
        AVLNode newNode = node.getRightChild ();
        node.setRightChild (newNode.getLeftChild ());
        newNode.setLeftChild (node);
        node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
        newNode.setHeight (max (height (newNode.getRightChild ()), node.getHeight ()) + 1);
        return newNode;
    }

    private AVLNode doubleWithLeft (AVLNode node){
        node.setLeftChild (rotateWithRight (node.getLeftChild ()));
        return rotateWithLeft (node);
    }


    private AVLNode doubleWithRight (AVLNode node){
        node.setRightChild (rotateWithLeft (node.getRightChild ()));
        return rotateWithRight (node);
    }

    public static int max (int first, int second){
        if (first >= second)
            return first;
        else
            return second;
    }

    private AVLNode getReplacementRecursive(AVLNode node, AVLNode parent, AVLNode target){
        if (node == null)
            return parent;
        AVLNode replacement = getReplacementRecursive(node.getRightChild(), node, target);
        if (parent.getRightChild() == replacement){
            parent.setRightChild(null);
            if (parent.getLeftChild() == null && parent != target)
                parent.setHeight(parent.getHeight() -1);
        }
        else{
            updateHeight(parent);
        }
        return replacement;
    }

    private void updateHeight(AVLNode node){
        int iLeftHeight = -1;
        int iRightHeight = -1;
        if (node.getLeftChild() != null)
            iLeftHeight = node.getLeftChild().getHeight();
        if (node.getRightChild() != null)
            iRightHeight = node.getRightChild().getHeight();
        node.setHeight(max(iLeftHeight, iRightHeight) + 1);
    }
}