function toBookmarkAdd () {
    location.href = "http://localhost:8080/view/bookmark-group-add.jsp";
}

function addBookmark () {
    const bookmarkName = document.getElementById("bookmarkName").value;
    const orderNum = document.getElementById("orderNum").value;

    if (!bookmarkName || !orderNum) {
        alert("내용을 입력해주세요.");
    } else {
        document.getElementById("bookmarkForm").submit();
    }
}