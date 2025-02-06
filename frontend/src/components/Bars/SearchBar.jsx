import React from "react";
import icon_search from "../../assets/icons/icon_search.png";
import icon_aisearch4 from "../../assets/icons/icon_AIsearch.png";
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

        <Link
          to="/aiplannerstart"
          className="flex items-center justify-center h-8 w-8 bg-white rounded-full shadow-sm"
        >
          <img src={icon_aisearch4} alt="Google Icon" className="h-5 w-5" />
        </Link>
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
