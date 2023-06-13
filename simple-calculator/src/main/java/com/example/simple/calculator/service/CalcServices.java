package com.example.simple.calculator.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simple.calculator.controller.CalcRequest;
import com.example.simple.calculator.exception.CalcException;

@Service
public class CalcServices {

	public static int getResult(CalcRequest calcRequest) throws CalcException {
		// System.out.println(calcRequest);
		List<String>operatorList=new ArrayList<>();
		operatorList.add("+");
		operatorList.add("-");
		operatorList.add("%");
		
		int result = 0;
		String operator = calcRequest.getOperator();
		if (!operatorList.contains(operator)) {
			throw new CalcException("invalid opertaor");
		}
		// String firstNumber = ;
		// boolean flag = true;
		// for (int i = 0; i < firstNumber.length(); i++) {
		// if (i == 0 && firstNumber.charAt(i) == '-')
		// continue;
		// if (!Character.isDigit(firstNumber.charAt(i)))
		// flag = false;
		//
		// }
		
			int A = Integer.parseInt(calcRequest.getFirststr());
			int B = Integer.parseInt(calcRequest.getSecondstr());

			// if (calcRequest.getOperator().contentEquals("+")) {
			// result = A + B;
			// } else if (calcRequest.getOperator().contentEquals("-")) {
			// result = A - B;
			// } else if (calcRequest.getOperator().contentEquals("/")) {
			// result = A % B;
			// } else {
			// throw new CalcException("stating invalid operator");
			//
			// }
			
			switch (operator) {
			case "+":
				result = A + B;

				break;
			case "-":
				result = A - B;
				break;
			case "%":
				result = A % B;
//			default:
//				//System.out.println("static invalid operator");
//				throw new CalcException("static invalid operator");

			}

	

		return result;
		// return 0;
	}

}
