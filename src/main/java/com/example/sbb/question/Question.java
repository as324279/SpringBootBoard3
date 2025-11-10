package com.example.sbb.question;
import java.time.LocalDateTime;
import jakarta.persistence.ManyToOne;
import com.example.sbb.user.SiteUser;

import java.time.LocalDateTime; 
import java.util.List;

import com.example.sbb.answer.Answer;

import jakarta.persistence.CascadeType; 
import java.util.Set;
import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany; 

import lombok.Getter; 
import lombok.Setter; 

@Getter
@Setter
@Entity
public class Question {
	
	private LocalDateTime modifyDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 200)
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
	
	@ManyToOne
	private SiteUser author;
	
	@ManyToMany
	Set<SiteUser> voter;
	
}
