package com.keys.Keys_Distillery;

import com.keys.Keys_Distillery.organization.OrgRepository;
import com.keys.Keys_Distillery.organization.Organization;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@Configuration
public class KeysDistilleryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeysDistilleryApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(OrgRepository repository) throws Exception {
		return args -> {

			Document document = Jsoup.connect("https://nablagoe.ru/rostovskaya-oblast").get();
			Elements titles = document.select("h2.entry-title");
			Elements links = document.select("a.post-thumbnail");
			Elements pics = document.select("img.attachment-post-thumbnail.size-post-thumbnail.wp-post-image");
			for (int i=0; i < 100; i++){
				System.out.println(titles.get(i).text());
				System.out.println(links.get(i).attr("href"));
				System.out.println(pics.get(i).attr("src"));
				System.out.println("-----------------------------------------");
				repository.save(new Organization(
						titles.get(i).text(),
						links.get(i).attr("href"),
						pics.get(i).attr("src")));
			}
		};
	}

}
