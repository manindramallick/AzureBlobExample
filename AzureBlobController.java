package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class AzureBlobController {

    private AzureBlobService azureBlobService;
    public AzureBlobController(AzureBlobService azureBlobService){
        this.azureBlobService=azureBlobService;
    }
    @GetMapping("/{container}/{blob}")
    public String getImageUrl(@PathVariable("container") String containerName, @PathVariable("blob") String blobName) {
        return azureBlobService.getImageUrl(containerName, blobName);
    }

}
