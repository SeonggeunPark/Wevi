import icon_home from "../../assets/8687429_ic_fluent_home_regular_icon.png";
import icon_calendar from "../../assets/9025172_calendar_blank_icon.png";
import icon_mypage from "../../assets/4781820_avatar_male_man_people_person_icon.png";
import icon_search from "../../assets/5349754_explore_find_magnifier_magnifying glass_search_icon.png";
import icon_alarm from "../../assets/4781824_alarm_alert_attention_bell_clock_icon.png";
import icon_arrow from "../../assets/2849832_arrows_navigation_arrow_left_back_icon.png";
import icon_progress from "../../assets/9025639_list_bullets_icon.png";

import { Link } from "react-router-dom";

function BottomNavigationBar() {
  return (
    <nav className="bg-[#FFFDFA] fixed bottom-0 w-full flex justify-around py-3 shadow-[0_-4px_6px_-1px_rgba(0,0,0,0.1),0_-2px_4px_-2px_rgba(0,0,0,0.1)]">
      {/* 홈 */}
      <Link to="/" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={icon_home}
          alt="Home Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">홈</span>
      </Link>

      {/* 검색 */}
      <Link to="/search" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={icon_search}
          alt="Search Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">검색</span>
      </Link>

      {/* 일정 */}
      <Link to="/calendar" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={icon_calendar}
          alt="Calendar Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">일정</span>
      </Link>

      {/* 진행도 */}
      <Link to="/progress" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={icon_progress}
          alt="Progress Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">진행도</span>
      </Link>

      {/* 마이페이지 */}
      <Link to="/mypage" className="flex flex-1 flex-col items-center gap-1">
        <img
          src={icon_mypage}
          alt="Mypage Icon"
          className="h-8 w-8 object-contain"
        />
        <span className="text-sm text-center">마이페이지</span>
      </Link>
    </nav>
  );
}

export default BottomNavigationBar;
