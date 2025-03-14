package com.example.demo.service;

import com.example.demo.model.Product;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private SolrClient solrClient;

    public String addProduct(Product product) throws Exception {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", product.getId());
        document.addField("name", product.getName());
        document.addField("price", product.getPrice());

        UpdateResponse response = solrClient.add(document);
        solrClient.commit();
        return response.getStatus() == 0 ? "Product added successfully!" : "Failed to add product.";
    }

	public String getAllProducts() {
		// TODO Auto-generated method stub
		return "fetched all products";
	}

	public List<Product> searchProducts(String keyword) throws Exception {
        SolrQuery query = new SolrQuery();
        query.set("q", "name:" + keyword + " OR id:" + keyword); 

        System.out.println("Executing Solr Query: " + query.toString()); // Debugging log

        QueryResponse response = solrClient.query(query);
        List<Product> products = response.getBeans(Product.class);

        System.out.println("Solr Response: " + products); // Log response

        return products;
    }

	public String updateProduct(String id, Product product) throws Exception {
        // Create SolrInputDocument to update the product fields
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", id);
        document.addField("name", product.getName());
        document.addField("price", product.getPrice());

        // Update the existing document in Solr
        UpdateResponse response = solrClient.add(document);
        solrClient.commit();

        return response.getStatus() == 0 ? "Product updated successfully!" : "Failed to update product.";
    }
}
