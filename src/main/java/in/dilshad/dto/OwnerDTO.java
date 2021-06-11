package in.dilshad.dto;

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
