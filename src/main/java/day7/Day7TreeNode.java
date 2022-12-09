package day7;

import java.util.List;

public class Day7TreeNode {
    public long size;
    public Day7TreeNode parent;
    public List<Day7TreeNode> children;
    public String name;

    public Day7TreeNode(String name){
        this.name = name;
    }

    public void addChild(Day7TreeNode node){
        node.parent = this;
        this.children.add(node);
    }

    public Day7TreeNode getChild(String name){
        return children.stream().filter(child -> child.name.equals(name)).findFirst().get();
    }
}