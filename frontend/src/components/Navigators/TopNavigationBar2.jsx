import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import icon_home from "../../assets/icons/icon_home.png";
import icon_calendar from "../../assets/icons/icon_calendar.png";
import icon_mypage from "../../assets/icons/icon_mypage.png";
import icon_search from "../../assets/icons/icon_search.png";
import icon_alarm from "../../assets/icons/icon_alaram.png";
import icon_arrow_bottom from "../../assets/icons/icon_arrow_bottom.png";
import icon_arrow_left from "../../assets/icons/icon_arrow_left.png";
import icon_progress from "../../assets/icons/icon_progress.png";
import icon_menu from "../../assets/icons/icon_menu.png";
import logo from "../../assets/logo.png";

function TopNavigationBar({ title }) {
  return (
    <header className="flex items-center w-full sticky top-0 left-0 right-0 justify-between px-4 py-3 bg-[#FFFDFA] shadow-md z-10">
      {/* 뒤로가기로 수정하기기 */}
      <Link to="/" className="flex items-center">
        <img
          src={icon_arrow_left} // 로고 이미지 경로
          alt="arrow"
          className="h-8 w-8 object-contain" // 로고 크기 조정
        />
      </Link>

      <span className="text-lg font-bold text-gray-900">{title}</span>

      <Link to="/menu" aria-label="Menu" className="p-2">
        <img src={icon_menu} alt="Menu Icon" className="h-8 w-8" />
      </Link>
    </header>
  );
}

TopNavigationBar.propTypes = {
  title: PropTypes.string.isRequired, // 검색 제목 (필수)
};

export default TopNavigationBar;
