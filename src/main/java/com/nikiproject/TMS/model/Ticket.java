package com.nikiproject.TMS.model;

import java.time.LocalDateTime;

import com.nikiproject.TMS.enums.TicketPriority;
import com.nikiproject.TMS.enums.TicketStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false , length = 2000)
	private String description;
	
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TicketPriority priority;
	
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id",nullable = false)
	private Category category;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by",nullable = false)
	private User createdby;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="assigned_to")
	private User assignedto;
	
	
	@Column(nullable = false, unique = true)
	private String ticketNumber;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	@PrePersist
	public void prePersist()
	{
		createdAt=LocalDateTime.now();
	}
	
	@PreUpdate
	public void preUpdate()
	{
		updatedAt=LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketPriority getPriority() {
		return priority;
	}

	public void setPriority(TicketPriority priority) {
		this.priority = priority;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getCreatedby() {
		return createdby;
	}

	public void setCreatedby(User createdby) {
		this.createdby = createdby;
	}

	public User getAssignedto() {
		return assignedto;
	}

	public void setAssignedto(User assignedto) {
		this.assignedto = assignedto;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
