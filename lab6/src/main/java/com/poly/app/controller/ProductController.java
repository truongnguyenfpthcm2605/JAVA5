package com.poly.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.app.enity.Product;
import com.poly.app.enity.Report;
import com.poly.app.impl.ProductServiceImpl;
import com.poly.app.service.SessionSevice;

@Controller
@RequestMapping("product")
public class ProductController {

	private final Integer pageSize = 8;

	@Autowired
	ProductServiceImpl productServiceImpl;

	@Autowired
	SessionSevice sessionSevice;

	// Search Min Max
	@GetMapping("view")
	private String view(Model model) {
		List<Product> products = productServiceImpl.findAll();
		model.addAttribute("list", products);
		return "search";
	}

	@PostMapping("search")
	private String reSearch(Model model, @RequestParam("min") Optional<Double> min,
			@RequestParam("max") Optional<Double> max) {
		Double minPrice = min.orElse(Double.MIN_VALUE);
		Double maxPrice = max.orElse(Double.MAX_VALUE);

		model.addAttribute("min", minPrice);
		if (maxPrice < minPrice) {
			model.addAttribute("message", "Vui lòng nhập Min bé hơn Max");
			return "search";
		}
		List<Product> products = productServiceImpl.findByPrice(minPrice, maxPrice);
		model.addAttribute("list", products);

		model.addAttribute("max", maxPrice);

		return "search";
	}

	// Search Page

	@GetMapping("viewPage")
	public String viewPage(Model model) {
		model.addAttribute("page", getPage(0));
		return "searchPage";
	}

	@PostMapping("search-and-page")
	private String reSearchPage(Model model, @RequestParam("keywords") Optional<String> keyword,
			@RequestParam("page") Optional<Integer> page) {

		String kwords = keyword.orElse(sessionSevice.getAttribute("keywords"));
		sessionSevice.setAttribute("keywords", kwords);

		Pageable pageable = PageRequest.of(page.orElse(0), pageSize);
		Page<Product> pages = productServiceImpl.findByKeywords("%" + kwords + "%", pageable);
		model.addAttribute("page", pages);
		return "searchPage";
	}

	@GetMapping("/page")
	public String Page(Model model, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("page", getPage(p.orElse(0)));
		return "searchPage";

	}

	public Page<Product> getPage(Integer number) {
		Pageable pageable = PageRequest.of(number, pageSize);
		Page<Product> page = productServiceImpl.findAllPage(pageable);
		return page;
	}

	// Repport

	@GetMapping("Report")
	private String report(Model model) {
		List<Report> list = productServiceImpl.getInventoryByCategory();
		model.addAttribute("list", list);
		return "Report";
	}

	// Sort And Page

	@GetMapping("viewPageSort")
	public String viewPageSort(Model model) {
		model.addAttribute("page", getPage(0));
		return "SortPage";
	}

	@GetMapping("pagesort")
	public String PageSort(Model model, @RequestParam("p") Optional<Integer> p) {
		model.addAttribute("page", getPage(p.orElse(0)));
		return "SortPage";

	}

	@PostMapping("search-and-sortPage")
	private String reSearchPageSort(Model model, @RequestParam("keywords") Optional<String> keyword,
			@RequestParam("page") Optional<Integer> page) {
		String sortKey = sessionSevice.getAttribute("sort") == null ? "price" : sessionSevice.getAttribute("sort");
		Page<Product> pages = productServiceImpl.findAllByNameLike("%" + keyword.get() + "%",
				getPageable(page.orElse(0), sortKey));
		model.addAttribute("page", pages);
		return "SortPage";
	}

	@GetMapping("sort")
	public String sort(Model model, @RequestParam("field") Optional<String> field,
			@RequestParam("p") Optional<Integer> p) {
		sessionSevice.setAttribute("sort", field.orElse("price"));
		Page<Product> page = productServiceImpl.findAllPage(getPageable(p.orElse(0), field.get()));
		model.addAttribute("page", page);
		return "SortPage";
	}

	private Pageable getPageable(Integer index, String sortKey) {
		Sort sort = Sort.by(Direction.DESC, sortKey);
		Pageable pageable = PageRequest.of(index, pageSize, sort);
		return pageable;
	}

	/// sortPrice
	@GetMapping("sortPrice")
	public String PageSortPrice(Model model) {
		model.addAttribute("list", productServiceImpl.findAll());
		return "SortPrice";

	}

	@PostMapping("sortPrice")
	public String PageSortPricePost(Model model, @RequestParam("sortPrice") Optional<Integer> sort) {
		
		List<Product> list = null;
		switch (sort.get()) {
		case 0:
			Sort sorts = Sort.by(Direction.DESC, "createdate");
			list = productServiceImpl.findAllSort(sorts);
			break;
		case 1:
			Sort sortMax = Sort.by(Direction.DESC, "price");
			list = productServiceImpl.findAllSort(sortMax);
			break;
		case 2:
			Sort sortsMin = Sort.by(Direction.ASC, "price");
			list = productServiceImpl.findAllSort(sortsMin);
			break;
		default:
			break;
		}
		model.addAttribute("list", list);
		return "SortPrice";

	}

}
