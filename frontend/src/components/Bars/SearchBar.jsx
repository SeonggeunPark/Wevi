import React from "react";
import icon_search from "../../assets/5349754_explore_find_magnifier_magnifying glass_search_icon.png";
import icon_aisearch1 from "../../assets/9027029_sparkle_thin_icon.png";
import icon_aisearch2 from "../../assets/9310102_star_stars_sparkle_sparkles_icon.png";
import icon_aisearch3 from "../../assets/9310142_star_sparkle_stars_sparkles_icon.png";
import icon_aisearch4 from "../../assets/9310142_star_sparkle_stars_sparkles_icon.png 9310102_star_stars_sparkle_sparkles_icon.png 9024956_sparkle_light_icon.png 9027029_sparkle_thin_icon.png.png";
import { Link } from "react-router-dom";

function SearchBar() {
  return (
    <section className="bg-white shadow-md p-4">
      <div className="flex items-center w-full bg-amber-100 rounded-full p-2 mb-4 ">
        {/* Google 아이콘 */}
        <div className="flex items-center justify-center h-8 w-8 bg-white rounded-full shadow-sm">
          <img src={icon_search} alt="Google Icon" className="h-5 w-5" />
        </div>

        {/* 검색 입력창 */}
        <input
          type="text"
          placeholder="검색"
          className="flex-1 bg-transparent px-4 text-sm text-gray-700 focus:outline-none"
        />

        {/* 갱신 아이콘 */}

        <Link to = '/aiplannerstart' className="flex items-center justify-center h-8 w-8 bg-white rounded-full shadow-sm">
          <img src={icon_aisearch4} alt="Google Icon" className="h-5 w-5" />
        </Link>
      </div>

      {/* 버튼 클릭에 따라서 하단 호텔/리조트 등 옵션 바뀌게 */}
      <div className="flex justify-between text-sm text-black-500 mb-4">
        <button className="cursor-pointer flex-grow text-center py-2 bg-[#900604] rounded mx-2">
          웨딩홀
        </button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-green-200 rounded mx-2">
          드레스
        </button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-green-200 rounded mx-2">
          스튜디오
        </button>
        <button className="cursor-pointer flex-grow text-center py-2 bg-black rounded mx-2">
          메이크업
        </button>
      </div>

      <div className="grid grid-cols-3 gap-4 mb-4">
        <select className="bg-gray-100 p-2 rounded-md">
          <option>호텔/리조트</option>
          <option>컨벤션</option>
          <option>하우스</option>
        </select>
        <input
          type="text"
          placeholder="지역"
          className="bg-gray-100 p-2 rounded-md"
        />
        <input
          type="date"
          className="bg-gray-100 p-2 rounded-md"
          placeholder="날짜 선택"
        />
      </div>
    </section>
  );
}

export default SearchBar;
