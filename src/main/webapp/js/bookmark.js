function addBookmark() {
    const select = document.getElementById("bookmarkGroupSelect");
    const id = select.options[select.selectedIndex].value;
    const mgrNo = document.getElementById("mgrNo").innerText;
    if(!id) {
        alert("북마크 그룹을 선택 해 주세요.");
    } else {
        location.href = "http://localhost:8080/bookmark-add-submit?id="+id+"&mgrNo="+mgrNo;
    }
}