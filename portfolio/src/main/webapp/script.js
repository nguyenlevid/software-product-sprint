// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['Hello world!', '¡Hola Mundo!', '你好，世界！', 'Bonjour le monde!'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}

async function addRandomText() {
    const responseFromServer = await fetch("/hello");
    const textFromResponse = await responseFromServer.text();

    const randomText = document.getElementById('random-text');
    randomText.innerText = textFromResponse;
}

async function addFacts() {
    const responseFromServer = await fetch("/facts");
    const textFromResponse = await responseFromServer.json();

    const fact = textFromResponse[Math.floor(Math.random() * textFromResponse.length)];

    const randomFact = document.getElementById('random-fact');
    randomFact.innerHTML = fact;
}

async function addContact() {
    // stop page from reloading
    var form = document.getElementById("contactForm");
    function handleForm(event) { event.preventDefault(); } 
    form.addEventListener('submit', handleForm);

    const responseFromServer = await fetch("/contact-form");
    const textFromResponse = await responseFromServer.text();

    // console.log(textFromResponse);
    // const contact = document.getElementById('contact-container');
    // contact.innerHTML = textFromResponse;

}


async function addComment() {

    const responseFromServer = await fetch("/comment-list", {
        headers : { 
          'Content-Type': 'application/json',
          'Accept': 'application/json'
         }}
        );
    const comments = await responseFromServer.json();
    
    console.log(comments);

    const commentListElement = document.getElementById('comment-list-container');
    commentListElement.innerHTML = '';
  
    for (var i = 0; i < comments.length; i++) {
        console.log(comments[i]);
        commentListElement.appendChild(
            createListElement(comments[i].comment));
    }

}

/** Creates an <li> element containing text. */
function createListElement(text) {
    const liElement = document.createElement('li');
    liElement.innerText = text;
    return liElement;
  }
