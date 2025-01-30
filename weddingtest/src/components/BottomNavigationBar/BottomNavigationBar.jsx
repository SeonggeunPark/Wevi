import React from "react";
import homeicon from "../../assets/homeicon.png";
import calendaricon from "../../assets/calendaricon.png";
import mypageicon from "../../assets/mypageicon.png";
import progressicon from "../../assets/progressicon.png";
import searchicon from "../../assets/searchicon.png";

import { Link } from "react-router-dom";

function BottomNavigationBar() {
  return (
    <nav className="bg-[#FFFDFA] fixed bottom-0 w-full flex justify-around py-3 shadow-[0_-4px_6px_-1px_rgba(0,0,0,0.1),0_-2px_4px_-2px_rgba(0,0,0,0.1)]">
      {/* 홈 */}
      <Link to="/" className="flex flex-1 flex-col items-center gap-1" >
        <img
          src={homeicon}
          alt="Home Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">홈</span>
      </Link>

      {/* 검색 */}
      <Link to="/search" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={searchicon}
          alt="Search Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">검색</span>
      </Link>

      {/* 일정 */}
      <Link to="/calendar" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={calendaricon}
          alt="Calendar Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">일정</span>
      </Link>

      {/* 진행도 */}
      <Link to="/progress" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={progressicon}
          alt="Progress Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">진행도</span>
      </Link>

      {/* 마이페이지 */}
      <Link to="/mypage" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={mypageicon}
          alt="Mypage Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">마이페이지</span>
      </Link>
    </nav>
  );
}

export default BottomNavigationBar;
