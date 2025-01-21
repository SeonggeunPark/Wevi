import { useState } from 'react';

import { CORE_CONCEPTS } from './data';
import Header from './components/Header/Header';
import TabButton from './components/TabButon';
import { EXAMPLES } from './data.js'

function CoreConcept({image, title, description}) {
  return (
  <li>
    <img src={image} alt="" />
    <h3>{title}</h3>
    <p>{description}</p>
  </li>
  )
}

function App() {
  const [ selectedTopic, setSelectedTopic ] = useState();

  function handleSelect(selectedButton) {
    setSelectedTopic(selectedButton);
    console.log(selectedTopic)
  }
  return (
    <div>
      <Header></Header>
      <main>
        <section id="core-concepts">
          <h2>Core Concepts</h2>
          <ul>
            {CORE_CONCEPTS.map((conceptItem) => 
            <CoreConcept key={conceptItem.title} {...conceptItem}/>)}
          </ul>
        </section>
        <section id="examples">
          <h2>Examples</h2>
          <menu>
            <TabButton isSelected={selectedTopic==='components'} onSelect={() => handleSelect('components')} label="Components"></TabButton>
            <TabButton isSelected={selectedTopic==='jsx'} onSelect={() => handleSelect('jsx')} label="JSX"></TabButton>
            <TabButton isSelected={selectedTopic==='props'} onSelect={() => handleSelect('props')} label="Props"></TabButton>
            <TabButton isSelected={selectedTopic==='state'} onSelect={() => handleSelect('state')} label="State"></TabButton>
          </menu>
            {!selectedTopic && <p>Please select a topic</p>}
            {selectedTopic && (
              <div id="tab-content">
                <h3>{EXAMPLES[selectedTopic].title}</h3>
                <p>{EXAMPLES[selectedTopic].description}</p>
                <pre>
                  <code>{EXAMPLES[selectedTopic].code}</code>
                </pre>
              </div>)}
        </section>
      </main>
    </div>
  );
}

export default App;