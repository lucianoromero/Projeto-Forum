package br.com.alura.forum.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.alura.forum.model.OpenTopicByCategory;
import br.com.alura.forum.repository.OpenTopicByCategoryRepository;
import br.com.alura.forum.repository.TopicRepository;

/**
 * @author Luciano
 * <br> Criando o agendamento por temo criando o relatorio 
 */
@ComponentScan
public class RegisterUnansweredTopicsTask {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private OpenTopicByCategoryRepository openTopicByCategoryRepository;

	
	@Scheduled(cron = "0 0 20 * * *")
	public void execute() {
		List<OpenTopicByCategory> topics = topicRepository.findOpenTopicsByCategory();
		this.openTopicByCategoryRepository.saveAll(topics);
	}

	

}
