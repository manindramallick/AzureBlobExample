package com.example.demo;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class AzureBlobService {

    private BlobServiceClient blobServiceClient;

    public AzureBlobService() {
        // Create a DefaultAzureCredential to authenticate with RBAC
        DefaultAzureCredentialBuilder credentialBuilder = new DefaultAzureCredentialBuilder();
        blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("your_blob_service_endpoint") // Replace with your Blob service endpoint URL
                .credential(credentialBuilder.build())
                .buildClient();
    }

    public String getImageUrl(String containerName, String blobName) {
        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);
        BlobClient blobClient = containerClient.getBlobClient(blobName);
        return blobClient.getBlobUrl();
    }


}
