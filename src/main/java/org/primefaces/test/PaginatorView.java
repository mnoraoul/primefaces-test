package org.primefaces.test;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("ttPaginatorView")
@ViewScoped
public class PaginatorView implements Serializable {

    private TreeNode<Document> root;
    private TreeNode selectedNode;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode();

        for (int i = 0; i < 50; i++) {
            TreeNode node = new DefaultTreeNode(new Document(i,"Node " + i, String.valueOf((int) (Math.random() * 1000)), "Document"), root);

            for (int j = 0; j < 5; j++) {
                new DefaultTreeNode(new Document(i,"Node " + i + "." + j, String.valueOf((int) (Math.random() * 1000)), "Document"), node);
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
}
