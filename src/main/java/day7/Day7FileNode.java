package day7;

public class Day7FileNode extends Day7TreeNode{
    public Day7FileNode(String name, long size){
        super(name);
        this.size = size;
        this.children = null;
    }
}
