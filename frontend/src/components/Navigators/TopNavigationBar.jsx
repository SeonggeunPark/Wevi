import { Link } from "react-router-dom";
import icon_home from "../../assets/8687429_ic_fluent_home_regular_icon.png";
import icon_calendar from "../../assets/9025172_calendar_blank_icon.png";
import icon_mypage from "../../assets/4781820_avatar_male_man_people_person_icon.png";
import icon_search from "../../assets/5349754_explore_find_magnifier_magnifying glass_search_icon.png";
import icon_alarm from "../../assets/4781824_alarm_alert_attention_bell_clock_icon.png";
import icon_arrow from "../../assets/2849832_arrows_navigation_arrow_left_back_icon.png";
import icon_progress from "../../assets/9025639_list_bullets_icon.png";
import icon_menu from "../../assets/9025668_list_icon.png";

import potatosearchicon from "../../assets/potatosearch.png";

function TopNavigationBar() {
  return (
    <header className="flex items-center w-screen sticky  top-0 justify-between px-4 py-3 bg-[#FFFDFA] shadow-md z-1">
      {/* 로고 섹션 */}
      <Link to="/" className="flex items-center">
        <img
          src={potatosearchicon} // 로고 이미지 경로
          alt="Logo"
          className="h-10 w-10 object-contain" // 로고 크기 조정
        />
        <span className="ml-2 text-lg font-bold text-gray-700">WEDDI</span>
      </Link>

      {/* 아이콘 섹션 */}
      <div className="flex items-center space-x-4">
        {/* 검색 아이콘 */}
        <Link
          to="/search"
          aria-label="Search"
          className="text-gray-600 hover:text-gray-800"
        >
          <img
            src={icon_search}
            alt="Search Icon"
            className="h-8 w-8 object-contain"
          />
        </Link>

        {/* 알림 아이콘 */}
        <Link
          to="/alarm"
          aria-label="Notifications"
          className="text-gray-600 hover:text-gray-800"
        >
          <img
            src={icon_alarm}
            alt="Alarm Icon"
            className="h-8 w-8 object-contain"
          />
        </Link>

        {/* 메뉴 아이콘 */}
        <Link
          to="/hamburger"
          aria-label="Menu"
          className="text-gray-600 hover:text-gray-800"
        >
          <img
            src={icon_menu}
            alt="Menu Icon"
            className="h-8 w-8 object-contain"
          />
        </Link>
      </div>
    </header>
  );
}

export default TopNavigationBar;
