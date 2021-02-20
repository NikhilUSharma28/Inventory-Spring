package com.inventory.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.DocumentException;
import com.inventory.download.DownloadList;
import com.inventory.entity.Inventory;
import com.inventory.service.InvenService;

@Controller
public class InvenController {

	@Autowired
	InvenService invenservice;

	@RequestMapping("/add")
	public String showform(Model m) {
		m.addAttribute("command", new Inventory());
		return "productform";
	}

	@RequestMapping("/save")
	private String insertProduct(Inventory inven) throws DataAccessException, IOException {
		invenservice.save(inven);
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String viewproduct(Model m) throws SQLException, IOException {
		List<Inventory> list = invenservice.getAll();
		m.addAttribute("list", list);
		return "viewproduct";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable int id, Model m) throws IOException {
		Inventory pro = invenservice.getById(id);
		m.addAttribute("command", pro);
		return "producteditform";
	}

	@RequestMapping("/editsave")
	private String updateProduct(Inventory inven) throws SQLException, IOException {
		invenservice.update(inven);
		return "redirect:/list";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) throws SQLException, IOException {
		invenservice.delete(id);
		return "redirect:/list";
	}

	@RequestMapping("/download")
	private void downloadList(HttpServletResponse response)
			throws SQLException, IOException, ServletException, DocumentException {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Product List.pdf";
		response.setHeader(headerKey, headerValue);
		List<Inventory> inventory = invenservice.getAll();
		DownloadList downloadobject = new DownloadList(inventory);
		downloadobject.downloadList(response);
	}
}