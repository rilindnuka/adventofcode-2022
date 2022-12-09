package day7;

import day.Day;
import util.AdventUtil;

import java.io.IOException;

public class Day7 extends Day {
    private Day7Tree tree;
    private Day7TreeNode currentActiveNode;

    private Long sum;
    private Long need;
    private Long min;
    private final Long CAPACITY = 70000000l;

    public Day7() throws IOException {
        super.setInput(AdventUtil.readFile("src/main/resources/day7.txt"));
        this.tree = new Day7Tree();
        this.currentActiveNode = null;
        sum = 0l;
    }
    private void cleanUp(){
        this.tree = new Day7Tree();
        this.currentActiveNode = null;
        sum = 0l;
    }

    @Override
    public void calculate(int part) {
        switch (part) {
            case 1:
                partOne();
                System.out.printf("Day seven (part one): %d\n", this.sum);
                break;
            case 2:
                partTwo();
                System.out.printf("Day seven (part two): %d\n", this.min);
                break;
            default:
                System.out.println("Wrong part");
        }

    }

    private void runTheLoop(){
        cleanUp();
        String[] fields = super.getInput().split("\n");
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].startsWith("$")){
                processCommand(fields[i]);
            }else {
                processOutput(fields[i]);
            }
        }
        this.setFileSizeSum(tree.root);
    }
    private void partTwo(){
        runTheLoop();
        need = 30000000 - (CAPACITY - tree.root.size);

        if(tree.root.size >= need)
            min = tree.root.size;

        calculateMinimum(tree.root);

    }

    private void partOne(){
        runTheLoop();
    }
    private void calculateMinimum(Day7TreeNode node) {
        if(node.size >= need && node.size < min)
            min = node.size;

        if(node instanceof Day7FileNode || node.children.isEmpty())
            return;

        for (Day7TreeNode childNode : node.children){
            calculateMinimum(childNode);
        }
    }

    private void setFileSizeSum(Day7TreeNode node) {
        for (Day7TreeNode childNode : node.children){
            if (childNode instanceof Day7DirNode)
                setFileSizeSum(childNode);
            node.size += childNode.size;
        }
        if (node.size <= 100000){
            this.sum += node.size;
        }
    }

    private void processOutput(String currentLine) {
        String[] tokens = currentLine.split(" ");

        if(tokens[0].equals("dir")){
            Day7DirNode dir = new Day7DirNode(tokens[1]);
            this.currentActiveNode.addChild(dir);
        }
        else{
            Day7FileNode file = new Day7FileNode(tokens[1], Long.parseLong(tokens[0]));
            this.currentActiveNode.addChild(file);
        }
    }

    private void processCommand(String command) {
        String[] tokens = command.split(" ");
        if(tokens[1].equals("cd")){
            if(tokens[2].equals("/")){
                this.currentActiveNode = tree.root;
            }
            else if (tokens[2].equals("..")){
                this.currentActiveNode = currentActiveNode.parent;
            }
            else{
                this.currentActiveNode = currentActiveNode.getChild(tokens[2]);
            }
        }
    }
}
