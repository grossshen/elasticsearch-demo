package tech.poorguy.elasticsearchdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author poorguy.tech
 * @Date 2019/4/21 21:06
 * @Mail 494939649@qq.com / maxwangein@gmail.com
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsBean {
    private String title;
    private String article;
}
