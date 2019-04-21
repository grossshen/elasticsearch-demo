package tech.poorguy.elasticsearchdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author poorguy.tech
 * @Date 2019/4/21 21:07
 * @Mail 494939649@qq.com / maxwangein@gmail.com
 **/
@RequestMapping("/api")
@RestController
public class Controller {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @GetMapping("/title")
    public String getDocument(/*@PathVariable String index, @PathVariable String title*/){
        return elasticsearchService.getDocumentByTitle("");
    }
}
