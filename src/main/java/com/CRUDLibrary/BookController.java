package com.CRUDLibrary;

    import java.util.List;
	import java.util.UUID;

    import Model.Entities.*;
    import LibraryBussinesLayer.BookMgr;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;

    import javax.annotation.Resource;

@Controller
@RequestMapping(value="/bookregistration")
public class BookController {

    //private RegistrationValidator validator = null;
    //private UserService userService = null;
    @Resource
    private BookMgr bookMgr;


    @RequestMapping(method=RequestMethod.GET)
    public String showForm(ModelMap model){
                            List<Book> books = bookMgr.getBook();
        	                model.addAttribute("books", books);
        	                Book book = new Book();
        	                model.addAttribute("book", book);
        	                return "bookregistration";
        	        }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView add(@ModelAttribute(value="book") Book book){
        	                ModelAndView mv = new ModelAndView("bookregistration");
                            bookMgr.persist(book);
                            book = new Book();
                            mv.addObject("book", book);
        	                mv.addObject("books", bookMgr.getBook());
        	                return mv;
        	        }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute(value="book") Book book){

        	                ModelAndView mv = new ModelAndView("bookregistration");
                            bookMgr.persist(book);
                            book = new Book();
                            mv.addObject("book", book);
        	                mv.addObject("book", bookMgr.getBook());
        	                return mv;
        	        }

    @RequestMapping(value="/delete", method=RequestMethod.POST)
    	        public ModelAndView delete(@ModelAttribute(value="book") Book book){
        	                ModelAndView mv = new ModelAndView("bookregistration");
   	                        bookMgr.deleteBook(book);
            	            book = new Book();
            	            mv.addObject("book", book);
        	                mv.addObject("books", bookMgr.getBook());
        	                return mv;
        	        }
    	}
