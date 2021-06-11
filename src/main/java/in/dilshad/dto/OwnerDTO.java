package in.dilshad.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class OwnerDTO {
	private String bikePlateNo;
	private String ownerName;
	private String ownerAddress;
	private Long ownerPhoneNo;
}
