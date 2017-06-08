package com.chitesh.lab.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
/*	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			
			new Topic("1", "Spring Framework","Spirng Framework Description"),
			new Topic("2","Core Java ","Java 8"),
			new Topic("3","WebServices ","Web service desciption")
			));
	*/
	
	public List<Topic> getAllTopics(){
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics :: add);
		return topics;
	}
	
	public Topic getTopic(String id){
		
		return topicRepository.findOne(id);
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic){
//		topics.add(topic);
		topicRepository.save(topic);
		
		
	}

	public void updateTopic(String id, Topic topic) {
		
		topicRepository.save(topic);
		
		/*for(int i =0 ;i<topics.size() ; i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}
		*/
	}

	public void deleteTopic(String id) {
		
		/*for(int i =0 ;i<topics.size() ; i++){
			Topic t = topics.get(i);
			if(t.getId().equals(id)){
				topics.remove(t);
			}
		}*/
		
//		topics.removeIf(t -> t.getId().equals(id));
		
		topicRepository.delete(id);
	}

}
