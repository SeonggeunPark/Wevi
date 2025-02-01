import TopNavigationBar from "../components/Navigators/TopNavigationBar2";
import BottomNavigationBar from "../components/Navigators/BottomNavigationBar";
import Section from "../components/Tabs/Section";
import TabBar1 from "../components/Tabs/TabBar1";
import TabButton from "../components/Tabs/TabButton";

import { useState } from "react";
import SearchBar from "../components/Bars/SearchBar";
import RecentSearch from "../components/RecentSearch";
import PopularServices from "../components/PopularServices";

export default function SearchPage() {
  return (
    <>
      <TopNavigationBar title="검색" />
      {/* 상단바 하단바 크기+4px 사이즈 */}
      <div className=" w-screen">
        <SearchBar />
        <RecentSearch />
        <PopularServices />
      </div>
      <BottomNavigationBar />
    </>
  );
}
