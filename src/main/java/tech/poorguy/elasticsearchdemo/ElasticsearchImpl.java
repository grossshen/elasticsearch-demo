package tech.poorguy.elasticsearchdemo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author poorguy.tech
 * @Date 2019/4/21 21:10
 * @Mail 494939649@qq.com / maxwangein@gmail.com
 **/
@Service
public class ElasticsearchImpl implements ElasticsearchService {

    @Override
    public String getDocumentByTitle(String title) {
        RestHighLevelClient client=new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

//        根据id查询
//        GetRequest getRequest = new GetRequest("test", "test_type", title);
        QueryBuilder queryBuilder = QueryBuilders.termsQuery("title","<h1 class=\"main-title\">“台独”政党女成员被曝和已婚官员过夜 将被调查</h1>");
//        QueryBuilder queryBuilder_title = QueryBuilders.matchQuery("title",keyword).boost(10);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(queryBuilder);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.fetchSource(new String[]{"id","title","abstract","source","date"},null);
        sourceBuilder.query(boolQueryBuilder);

        SearchRequest request = new SearchRequest("test");
        request.searchType("dfs_query_then_fetch");
        request.source(sourceBuilder);

        SearchResponse response = null;
        try {
            response = client.search(request);
            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SearchHits hits = response.getHits();
//        try {
//            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
//            client.close();
//            return getResponse.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}
