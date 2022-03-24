package com.project.service;

import com.project.domain.Habr;
import com.project.repository.HabrRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Service
public class HabrService {

private final HabrRepository habrRepository;

    public HabrService(HabrRepository habrRepository) {
        this.habrRepository = habrRepository;
    }


    public void SingAdd() throws IOException {
        Document doc = Jsoup.connect("https://habr.com/ru/news/").get();
        Elements news = doc.body().getElementsByTag("article");
        news.forEach(item -> {
            String themes = item.getElementsByClass("tm-article-snippet__title-link").get(0).text();
            if (habrRepository.findByThemes(themes) == null) {
                Habr habr = new Habr();
                habr.setTheme(themes);
                String writer = item.getElementsByClass("tm-user-info__username").get(0).text();
                habr.setWriter(writer);
                String data = item.getElementsByClass("tm-article-snippet__datetime-published").get(0).text();
                habr.setDate(data);
                if (item.getElementsByClass("tm-article-body tm-article-snippet__lead").size() != 0) {
                    String text = item.getElementsByClass("tm-article-body tm-article-snippet__lead").get(0).text();
                    habr.setText(text);

                }else{
                    int i = 0;
                }
                habrRepository.save(habr);
            }
        });
    }
    public void SingDelete(@RequestParam String theme) {
        if (habrRepository.findByThemes(theme) != null) {
            habrRepository.deleteById(theme);
        }
    }
    public void SingDeleteAdd(){
        habrRepository.deleteAll();
    }
    public List<Habr> getAllNews(){
        return habrRepository.findAll();
    }
}
