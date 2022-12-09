package day7;

import java.util.ArrayList;

public class Day7DirNode extends Day7TreeNode {
    public Day7DirNode(String name) {
        super(name);
        this.children = new ArrayList<>();
    }
}