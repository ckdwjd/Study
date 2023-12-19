package com.kh.springboot.menu.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springboot.menu.model.service.MenuService;
import com.kh.springboot.menu.model.vo.Menu;

import lombok.extern.slf4j.Slf4j;

@RestController // @Controller + @ResponseBody : 내부의 모든 handler는 body에 담김
@Slf4j
public class MenuController {

	@Autowired
	private MenuService mService;
	
	@GetMapping("/menus")
	public List<Menu> menus(HttpServletResponse response) {
		
		List<Menu> list = mService.selectMenuList();
		log.info("list = {} ", list);
		
		// 응답헤더 Access-Controll-Allow-Origin 속성 추가
		response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		
		return list;
	}
	
	
	@GetMapping("/menus/{type}/{taste}")
	public List<Menu> menus(
				@PathVariable String type,
				@PathVariable String taste
			) {
		log.info("type = {} , taste = {} ", type, taste );
		
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("type", type);
		paramMap.put("taste", taste);
		
		List<Menu> list = mService.selectMenuListByTypeAndTaste(paramMap);
		log.info("list = {} " , list);
	
		return list;
	}
	
	
	/*
	 * @RequestBody 요청 시 전달한 값 중 body에 작성된 "Json"문자열을 java의 객체로 변환
	 */
	//@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
	// CrossOrigin? : 특정 오리진에 대한 cors정책을 허용할 떄 사용
	@PostMapping("/menu")
	public Map<String, Object> insertMenu(@RequestBody Menu menu) {
		
		log.info("menu = {} ", menu);
		
		int result = mService.insertMenu(menu);
		
		Map<String, Object> map = new HashMap();
		
		if(result > 0) {
			map.put("msg", "메뉴 등록 성공");
		} else {
			map.put("msg", "메뉴 등록 실패");
		}
		
		return map;
	}
	
	
//	@GetMapping("/menu/{id}")
//	public Menu selectOneMenu(@PathVariable String id) {
//		return mService.selectOneMenu(id);
//	}
	
	
	// ResponseEntity
	// 존재하지 않는 메뉴번호를 요청한 경우 null값 반환이 아니라 404응답 상태를 반환
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> selectOneMenu(@PathVariable String id) {
		
		Menu menu =  mService.selectOneMenu(id);
		
		if(menu == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(menu);
		}
	}
	
	
	@PutMapping("/menu/{id}")
	public Map<String, Object> updateMenu( @PathVariable int id, @RequestBody Menu menu) {
		
		int result = mService.updateMenu(menu);
		
		Map<String, Object> map = new HashMap();
		map.put("msg", "메뉴 수정 성공");
		
		return map;
	}
	
	
	@DeleteMapping("/menu/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable int id) {
		
		int result = mService.deleteMenu(id);
		
		if(result > 0) {
			
			Map<String, Object> map = new HashMap();
			map.put("msg", "성공적으로 삭제가 완료되었습니다.");
			return new ResponseEntity(map , HttpStatus.OK);
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
}
