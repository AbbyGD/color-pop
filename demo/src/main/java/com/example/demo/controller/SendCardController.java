package com.example.demo.controller;

import com.example.demo.config.SendCardConfig;
import com.example.demo.enity.Cards;
import com.example.demo.utils.ReadExcelUtil;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wj
 * @date 2018/7/10
 */
@RestController
@RequestMapping("/card")
public class SendCardController {

    @GetMapping("/send")
    public String send()
    {
        List<String[]> list = ReadExcelUtil.read(SendCardConfig.file_path, 0, "UTF-8");
        System.out.println("list size :"+list.size());
        for(int i = SendCardConfig.begin_line;i<list.size();i++)
        {
            String[] info = list.get(i);
            if (info[0] == null || info[0].isEmpty()) {
                continue;
            }
            String code = info[SendCardConfig.code_index];
            String cardId = SendCardConfig.card_id;
            String url = SendCardConfig.url;
            Cards cards = new Cards();
            cards.setCardId(cardId);
            cards.setCodes(code);
            HttpEntity<Cards> entity = getHttpEntity(cards);
            ParameterizedTypeReference<Object> typeReference = new ParameterizedTypeReference<Object>() {
            };
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.exchange(url, HttpMethod.POST, entity, typeReference).getBody();
        }
        return "1";
    }

    private <T> HttpEntity<T> getHttpEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.APPLICATION_JSON_UTF8;
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8.toString());
        HttpEntity<T> entity = new HttpEntity<>(t, headers);
        return entity;
    }
}
