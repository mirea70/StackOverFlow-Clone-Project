let boardList = document.querySelector(".boardList")
let boardSoket = document.querySelector(".boardSoket")
let gesipanPage = document.querySelector(".gesipan_page")


const converter = function (x) {
    const boardContent = document.createElement("div")
    boardContent.className = "boardContent"
    boardContent.id = board[x].question_id
    const boardView = document.createElement("div")
    boardView.className = "boardView"
    boardView.textContent = board[x].view + ' views'
    const boardMain = document.createElement("div")
    boardMain.className = "boardMain"
    const boardtitle = document.createElement("a")
    boardtitle.className = "boardtitle"
    boardtitle.href = "boardDetail.html"
    boardtitle.textContent = board[x].title
    const boardtext = document.createElement("div")
    boardtext.className = "boardtext"
    boardtext.textContent = board[x].contents
    const tagMaker = document.createElement("div")
    tagMaker.className = "tagMaker"
    const boardTag = document.createElement("div")
    boardTag.classList = "boardTag"
    var abc = board[x].tags.split(" ")
    for(let i = 0 ; i < abc.length ; i++) {
      var newtag = document.createElement("div")
      newtag.className = "tag"
      newtag.textContent = abc[i]
      boardTag.append(newtag)
    }
    const boardMaker = document.createElement("div")
    boardMaker.classList = "boardMaker"
    const makerName = document.createElement("div")
    makerName.classList = "makerName"
    makerName.textContent = board[x].writer
    const asked = document.createElement("div")
    asked.textContent = "asked"
    const makerTime = document.createElement("div")
    makerTime.classList = "makerTime"
    makerTime.textContent = board[x].created_at
    boardMaker.append(makerName, asked, makerTime)
    tagMaker.append(boardTag, boardMaker)
    boardMain.append(boardtitle, boardtext, tagMaker)
    boardContent.append(boardView, boardMain)
    boardSoket.append(boardContent)
}

const converterButton = function (j) {
    const gesipanButton = document.createElement("button")
    gesipanButton.className = "gesipan_button"
    gesipanButton.textContent = j
    gesipanPage.append(gesipanButton)
}

const render = (x) => {
    let count = 0;
    if(board.length < x + 20) {
      count = board.length
    }else {
      count = x + 20
    }
    for(i = x ; i < count ; i++) {
        converter(i)
    }
}

const renderButton = (x) => {
    let count = 0 ;
    if(board.length/20 > x + 10) {
        count = x + 10
    }else {
        count = board.length/20
    }
    for(j = x ; j < count ; j++) {
        converterButton(j+1)
    }
}

render(0)
renderButton(0)



let def = document.querySelectorAll(".gesipan_button")
    def.forEach.call(def, function(e) {
    e.addEventListener("click", qwer)
    function qwer () {
      let count = (Number(e.textContent)-1) * 20  
      console.log(e.textContent)
      console.log(count)
      const boardContent = document.querySelectorAll('.boardContent')
      for(let a of boardContent) {
        a.remove()
      }
      render(count)
      let abc = document.querySelectorAll(".boardContent")
      abc.forEach.call(abc, function(e) {
      e.addEventListener("click", dsfd)
      function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
      })  
      }
    })    

let abc = document.querySelectorAll(".boardContent")
    abc.forEach.call(abc, function(e) {
    e.addEventListener("click", dsfd)
    function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
    })    

let gesipanPageButtonP = document.querySelector(".gesipan_page_button_p")
let gesipanPageButtonN = document.querySelector(".gesipan_page_button_n")
let buttonCount = 0
gesipanPageButtonP.onclick = function() {
    if(buttonCount !== 0){
        const gesipanR = document.querySelectorAll('.gesipan_button')
        for(let a of gesipanR) {
          a.remove()
        }
      buttonCount = buttonCount - 10
      const gesipanPage = document.querySelector(".gesipan_page")
      renderButton(buttonCount)
      gesipanPage
      } 
      let def = document.querySelectorAll(".gesipan_button")
    def.forEach.call(def, function(e) {
    e.addEventListener("click", qwer)
    function qwer () {
      let count = (Number(e.textContent)-1) * 20  
      console.log(e.textContent)
      console.log(count)
      const boardContent = document.querySelectorAll('.boardContent')
      for(let a of boardContent) {
        a.remove()
      }
      render(count)
      let abc = document.querySelectorAll(".boardContent")
      abc.forEach.call(abc, function(e) {
      e.addEventListener("click", dsfd)
      function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
      })  
      }
    })    

let abc = document.querySelectorAll(".boardContent")
    abc.forEach.call(abc, function(e) {
    e.addEventListener("click", dsfd)
    function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
    })   
}  
gesipanPageButtonN.onclick = function() {
    if(buttonCount < Math.ceil(board.length/20)-10){
        const gesipanR = document.querySelectorAll('.gesipan_button')
          for(let a of gesipanR) {
            a.remove()
          }
        buttonCount = buttonCount + 10
        const gesipanPage = document.querySelector(".gesipan_page")
        renderButton(buttonCount)
        gesipanPage
        }  
        let def = document.querySelectorAll(".gesipan_button")
    def.forEach.call(def, function(e) {
    e.addEventListener("click", qwer)
    function qwer () {
      let count = (Number(e.textContent)-1) * 20  
      console.log(e.textContent)
      console.log(count)
      const boardContent = document.querySelectorAll('.boardContent')
      for(let a of boardContent) {
        a.remove()
      }
      render(count)
      let abc = document.querySelectorAll(".boardContent")
      abc.forEach.call(abc, function(e) {
      e.addEventListener("click", dsfd)
      function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
      })  
      }
    })    

let abc = document.querySelectorAll(".boardContent")
    abc.forEach.call(abc, function(e) {
    e.addEventListener("click", dsfd)
    function dsfd () {
      console.log(e.id)
      localStorage.removeItem("key")
      localStorage.setItem("key", e.id)
      }
    })  
}