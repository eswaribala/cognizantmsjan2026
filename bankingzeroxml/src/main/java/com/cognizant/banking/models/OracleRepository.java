package com.cognizant.banking.models;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class OracleRepository extends Repository {
	private boolean openSource;

}
