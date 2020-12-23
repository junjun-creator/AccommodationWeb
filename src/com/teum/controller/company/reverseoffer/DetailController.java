package com.teum.controller.company.reverseoffer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teum.dao.entity.OfferableRoomListView;
import com.teum.dao.entity.ReverseListView;
import com.teum.dao.entity.RoomImageListView;
import com.teum.entity.Offer;
import com.teum.entity.ReverseOffer;
import com.teum.service.AccService;
import com.teum.service.OfferService;
import com.teum.service.ReverseOfferService;
import com.teum.service.RoomImageService;
import com.teum.service.RoomService;

@WebServlet("/company/reverseOffer/detail")
public class DetailController extends HttpServlet {
	
	private AccService accService;
	private OfferService offerService;
	private RoomService roomService;
	private RoomImageService roomImageService;
	private ReverseOfferService reverseOfferService;
	
	public DetailController() {
		accService = new AccService();
		offerService = new OfferService();
		roomService = new RoomService();
		roomImageService = new RoomImageService();
		reverseOfferService = new ReverseOfferService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("email") == null) 		  // 로그인이 안된 경우
			response.sendRedirect("/signin");
		else if(((int)session.getAttribute("type")) != 1) // 기업이 아닌 경우
			response.sendRedirect("/index");
		else {
			int companyId = (int) session.getAttribute("id");
			
			/*----companyId로 등록된 모든 숙소 ID 뽑기----*/
			List<Integer> accIds = accService.getIds(companyId,0);
			Integer[] accIds_ = accIds.toArray(new Integer[accIds.size()]);
			List<String> accIdsList = new ArrayList<>();
			
			for (int i = 0; i < accIds_.length; i++)
				accIdsList.add(String.valueOf(accIds_[i]));
			
			String accIdsCSV = String.join(",", accIdsList);
			
			
			
			/*----뽑은 숙소ID로 등록된 offer ID 모두 뽑기----*/
			List<Integer> offerIds = offerService.getIds(accIdsCSV);
			Integer[] offerIds_ = offerIds.toArray(new Integer[offerIds.size()]);
			List<String> offerIdsList = new ArrayList<>();
			
			for (int i = 0; i < offerIds_.length; i++)
				offerIdsList.add(String.valueOf(offerIds_[i]));
			
			String offerIdsCSV = String.join(",", offerIdsList);
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			
			
			/*----뽑은 offer ID로 reverse Offer 정보 모두 뽑기----*/
			List<ReverseOffer> reverseOfferList = reverseOfferService.getList(offerIdsCSV);
			
			List<Integer> finalOfferIds = new ArrayList<>();
			
			for (int i = 0; i < reverseOfferList.size(); i++) 
				finalOfferIds.add(reverseOfferList.get(i).getOfferId());
			
			Integer[] finalOfferIds_ = finalOfferIds.toArray(new Integer[finalOfferIds.size()]);
			List<String> finalOfferIdsList = new ArrayList<>();
			
			for (int i = 0; i < finalOfferIds_.length; i++)
				finalOfferIdsList.add(String.valueOf(finalOfferIds_[i]));
			
			String finalOfferIdsCSV = String.join(",", finalOfferIdsList);
			
			
			
			
			
			/*----뽑은 reverse offer에 들어있는 offer id로 해당하는 offer만 다시 뽑기----*/
			List<Offer> offerList = offerService.getListByOfferIds(finalOfferIdsCSV);
			//List<Offer> offerList = offerService.getList(page, );
			
			
			
			int page = 1;
			int offerId = 0;
			String page_ = request.getParameter("page");
			String offerId_ = request.getParameter("offerId");
			
			// 개인회원이 보낸 제안이 최소 1개라도 있는 경우엔 첫 번째 제안을 디폴트 값으로 설정
			if(!offerList.isEmpty())
				offerId = offerList.get(0).getId();
			
			if(page_ != null && !page_.equals(""))
				page = Integer.parseInt(page_);
			
			if(offerId_ != null && !offerId_.equals(""))
				offerId = Integer.parseInt(offerId_);
			
			
			// 제안목록중 원하는 제안을 클릭한 경우 offerId에 클릭한 offer id를 대입
			if(offerId_ != null && !offerId_.equals(""))
				offerId = Integer.parseInt(offerId_);
			System.out.println("offerId: " + offerId);
			List<ReverseListView> roomList = roomService.getReversedRoomList(page, offerId);
			
			
			
			
			/* 개인회원에게 보낸 룸 정보 뽑기 */
//			List<ReverseListView> roomList = new ArrayList<>();
//			
//			for (ReverseOffer reverseOffer : reverseOfferList) {
//				int roomId = reverseOffer.getRoomId();
//				roomList.add(roomService.get(roomId));
//			}
			
			request.setAttribute("offerList", offerList);
			request.setAttribute("roomList", roomList);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
