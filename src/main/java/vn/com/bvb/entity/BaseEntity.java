package vn.com.bvb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

	@CreatedBy
    @Column(name = "created_by", updatable = false)
	private String createdBy;

	@CreatedDate
    @Column(name = "created_date", updatable = false)
	private Date createdDate;

	@LastModifiedBy
    @Column(name = "modified_by")
	private String modifiedBy;

	@LastModifiedDate
    @Column(name = "modified_date")
	private Date modifiedDate;

}
