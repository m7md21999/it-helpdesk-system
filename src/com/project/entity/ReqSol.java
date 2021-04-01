package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="req_sol")
public class ReqSol {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="sol_id")
		private int id;
		
		@Column(name="req_id")
		private int req_id;
		
		@NotNull(message="required!")
		@NotBlank(message="description is required!")
		@Size(min=1, message=" required!")
		@Column(name="sol_desc")
		private String description;
		
		@Column(name="sol_date")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private Date finishDate;
		
		public ReqSol(){}
		

		public ReqSol(int req_id, String description, Date finishDate) {
			super();
			this.req_id = req_id;
			this.description = description;
			this.finishDate = finishDate;
		}


		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getFinishDate() {
			return finishDate;
		}

		public void setFinshDate(Date finishDate) {
			this.finishDate = finishDate;
		}


		public int getReq_id() {
			return req_id;
		}


		public void setReq_id(int req_id) {
			this.req_id = req_id;
		}
		
		
}
