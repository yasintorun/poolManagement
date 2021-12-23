package com.yasintorun.poolManagement.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity_content")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name; //Etkinlik Adı

	@Column(name="price")
	private int price; //Etkinliğe katılım için gerekli fiyat

	@Column(name="maximum_member")
	private int maximumMember; // En fazla kaç kişi katılabilir?

	@Column(name="is_special")
	private boolean isSpecial; // Etkinliği yönetici mi düzenliyor yoksa farklı biri mi?

	@Column(name="is_public")
	private boolean isPublic; // Herkes katılabilir mi? Halka açık mı?
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_time")
	private String startTime;

	@Column(name="end_time")
	private String endTime;

	@Column(name="date")
	private LocalDate date;

	@Column(name="created_by")
	private String createdBy; //Kim oluşturmuş
	
	@Column(name="created_phone")
	private String createdPhone; //Oluşturan kişinin telefon numarası

	@Column(name="created_at")
	private LocalDate createdAt; //Oluşturulma tarihi

	@Column(name="status")
	private boolean status;
	
	@ManyToOne()
	@JoinColumn(name="pool_id")
	private Pool pool; //Etkinliğin yapılacağı havuz

	@ManyToOne()
	@JoinColumn(name="activity_id")
	private Activity activity; //Etkinlik türü
}
