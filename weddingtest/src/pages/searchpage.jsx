import TopNavigationBar from "../components/Navigators/TopNavigationBar2";
import BottomNavigationBar from "../components/Navigators/BottomNavigationBar";
import Section from "../components/Tabs/Section";
import TabBar1 from "../components/Tabs/TabBar1";
import TabButton from "../components/Tabs/TabButton";

import { useState } from "react";

export default function SearchPage() {
  const [selectedTopic, setSelectedTopic] = useState();

  function handleSelect(selectedButton) {
    // selectedButton => '웨딩홀', '드레스', '스튜디오', '헤어/메이크업'
    setSelectedTopic(selectedButton);
    // console.log(selectedTopic);
  }

  console.log("APP COMPONENT EXECUTING");

  let tabContent = <p>Please select a topic.</p>;

  if (selectedTopic) {
    tabContent = (
      <div id="tab-content">
        <h3>test</h3>
      </div>
    );
  }
  return (
    <>
      <TopNavigationBar title="검색" />
      <Section title="Examples" id="examples">
        <TabBar1
          buttons={
            <>
              <TabButton
                isSelected={selectedTopic === "웨딩홀"}
                onClick={() => handleSelect("웨딩홀")}
              >
                웨딩홀
              </TabButton>
              <TabButton
                isSelected={selectedTopic === "드레스"}
                onClick={() => handleSelect("드레스스")}
              >
                드레스
              </TabButton>
              <TabButton
                isSelected={selectedTopic === "스튜디오"}
                onClick={() => handleSelect("스튜디오")}
              >
                스튜디오
              </TabButton>
              <TabButton
                isSelected={selectedTopic === "헤어메이크업"}
                onClick={() => handleSelect("헤어메이크업")}
              >
                State
              </TabButton>
            </>
          }
        ></TabBar1>
        {tabContent}
      </Section>
      <BottomNavigationBar />
    </>
  );
}
