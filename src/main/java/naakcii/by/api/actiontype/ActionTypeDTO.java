package naakcii.by.api.actiontype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ActionTypeDTO {
	
	private String name;
	private String icon;
	
	public ActionTypeDTO(ActionType actionType) {
		this.name = actionType.getName();
		this.icon = actionType.getIcon();
	}
}
