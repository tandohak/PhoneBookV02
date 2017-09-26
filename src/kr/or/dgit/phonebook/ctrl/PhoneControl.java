package kr.or.dgit.phonebook.ctrl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import kr.or.dgit.phonebook.DTO.Phone;

public class PhoneControl {
	private Map<String, Phone> phoneBook;
	
	public PhoneControl() {
		phoneBook = new HashMap<>();
		phoneBook.put("태연", new Phone("태연", "대구", "010-1111-1111"));
		phoneBook.put("아이유", new Phone("아이유", "서울", "010-2222-2222"));
		phoneBook.put("김태희", new Phone("김태희", "부산", "010-3333-3333"));
	}

	@Override
	public String toString() {
		return String.format("PhoneControl [phoneBook=%s]", phoneBook);
	}

	public boolean insertPhone(Phone newPhone) {
		if (isExist(newPhone)) {
			return false;
		}

		phoneBook.put(newPhone.getName(), newPhone);
		return true;
	}

	public boolean isExist(Phone newPhone) {
		return phoneBook.containsKey(newPhone.getName());
	}

	public boolean deletePhone(Phone delPhone) {
		if (!isExist(delPhone)) {
			return false;
		}
		phoneBook.remove(delPhone.getName());
		return true;
	}

	public Phone searchPhone(Phone search) {
		if (!isExist(search)) {
			return null;
		}

		return phoneBook.get(search.getName());

	}

	public Object[][] showPhone() {
		Object[][] datas = new Object[phoneBook.size()][];
		
		int i=0;
		for(Entry<String, Phone> e : phoneBook.entrySet()){
			Object[] arr= new Object[4]; // "번호 , 이름 , 주소, 연락처"
										 // 번호, "", "", ""
			arr[0] = i+1;
			Object[] phoneArr = e.getValue().toArray(); //"홍길동,대구,010~~";
			
			System.arraycopy(phoneArr, 0, arr, 1, phoneArr.length); //"번호", "홍길동", "대구", "010~~"
			datas[i] = arr;
			System.out.println(Arrays.toString(arr));
			
			i++;			
		}
		
		return datas;
	}

}
