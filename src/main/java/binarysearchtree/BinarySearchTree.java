package binarysearchtree;

import java.util.Comparator;

public class BinarySearchTree<T> implements BinarySearchTreeStructure<T> {
    private Comparator<T> comparator;
    private T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public String render(){
        String render = "";

        if (value != null) {
            render += value.toString();
        }

        if (left != null || right != null) {
            render += "(";
            if (left != null) {
                render += left.render();
            }
            render += ",";
            if (right != null) {
                render += right.render();
            }
            render += ")";
        }

        return render;
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public void insert(T value) {
        if (this.value == null) {
            this.value = value;
        } else if (comparator.compare(value, this.value) == 0) {
            throw new BinarySearchTreeException("The element is already present in the binary search tree");
        } else if (comparator.compare(value, this.value) < 0) {
            if (left == null) {
                left = new BinarySearchTree<>(comparator);
            }
            left.insert(value);
        } else {
            if (right == null) {
                right = new BinarySearchTree<>(comparator);
            }
            right.insert(value);
        }
    }

    @Override
    public boolean isLeaf() {
        if(value == null){
            throw new BinarySearchTreeException("The binary tree is empty");
         }

        return left == null && right == null;
    }

    @Override
    public boolean contains(T value) {
        boolean res=false;
        
        if(value == null){
            res=false;
         }
        else if (comparator.compare(value, this.value)==0){
            res = true;
        }
        else if (left!=null && comparator.compare(value, this.value) < 0){
            res = left.contains(value);
        }
        else if (right!=null && comparator.compare(value, this.value) > 0){
            res = right.contains(value);
        }
        return res;
    }

    @Override
    public T minimum() {
        if (value == null) {
            throw new BinarySearchTreeException("The binary tree is empty");
        }
        if (left == null) {
            return value;
        } else {
            return left.minimum();
        }
    }

    @Override
    public T maximum() {
        if (value == null) {
            throw new BinarySearchTreeException("The binary tree is empty");
        }
        if (right == null) {
            return this.value;
        } else {
            return right.maximum();
        }
    }

    @Override
    public void removeBranch(T value){
        if (comparator.compare(value, this.value) == 0) {
            this.value = null;
            this.left = null;
            this.right = null;
        } else if (left == null && right == null) {
            throw new BinarySearchTreeException("The element is not present in the binary search tree");
        } else if (comparator.compare(value, this.value) < 0) {
            if (left == null) {
                throw new BinarySearchTreeException("The element is not present in the binary search tree");
            }
            left.removeBranch(value);
        } else {
            if (right == null) {
                throw new BinarySearchTreeException("The element is not present in the binary search tree");
            }
            right.removeBranch(value);
        }
    }

    @Override
    public int size() {
        return (value==null?0:1) + (left==null?0:left.size()) + (right==null?0:right.size());
    }

    @Override
    public int depth() {
        if (value == null) {
            return 0;
        }
        else {
            return Math.max(left.depth(), right.depth()) + 1;
        }
    }

    // Complex operations
    // (Estas operaciones se incluirán más adelante para ser realizadas en la segunda
    // sesión de laboratorio de esta práctica)
}
