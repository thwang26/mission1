function toAddBookmarkGroupPage() {
    location.href = "http://localhost:8080/view/bookmarkGroup/bookmark-group-add.jsp";
}

function addBookmarkGroup() {
    const bookmarkName = document.getElementById("bookmarkName").value;
    const orderNum = document.getElementById("orderNum").value;

    if (!bookmarkName || !orderNum) {
        alert("내용을 입력해주세요.");
    } else {
        document.getElementById("bookmarkAddForm").submit();
    }
}

function toUpdateBookmarkGroupPage(id) {
    location.href = "http://localhost:8080/view/bookmarkGroup/bookmark-group-update.jsp?id="+id;
}

function updateBookmarkGroup() {
    const bookmarkName = document.getElementById("bookmarkName").value;
    const orderNum = document.getElementById("orderNum").value;

    if (!bookmarkName || !orderNum) {
        alert("내용을 입력해주세요.");
    } else {
        document.getElementById("bookmarkUpdateForm").submit();
    }
}

function deleteBookmarkGroup(id) {
    if (confirm("해당 북마크 그룹을 삭제하겠습니까?")) {
        location.href = "http://localhost:8080/view/bookmarkGroup/bookmark-group-delete.jsp?id="+id;
    }
}

function cancel() {
    history.go(-1);
}