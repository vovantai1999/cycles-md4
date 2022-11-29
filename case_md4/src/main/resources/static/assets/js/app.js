class App {
  static DOMAIN_API = "http://localhost:8080";

  static BASE_URL_PRODUCT = this.DOMAIN_API + "/api/products";
  static BASE_URL_CATEGORY = this.DOMAIN_API + "/api/categories";
  static BASE_URL_AUTH = this.DOMAIN_API + "/api/auth";
  static BASE_URL_USER = this.DOMAIN_API + "/api/users";

  static AlertMessageEn = class {
    static SUCCESS_CREATED = "Successful data generation !";
    static SUCCESS_UPDATED = "Data update successful !";
    static SUCCESS_DEPOSIT = "Deposit transaction successful !";
    static SUCCESS_WITHDRAW = "Withdrawal transaction successful !";
    static SUCCESS_TRANSFER = "Transfer transaction successful !";
    static SUCCESS_DEACTIVATE = "Deactivate the customer successfully !";

    static ERROR_400 = "The operation failed, please check the data again.";
    static ERROR_401 =
        "Unauthorized - Your access token has expired or is not valid.";
    static ERROR_403 =
        "Forbidden - You are not authorized to access this resource.";
    static ERROR_404 =
        "Not Found - The resource has been removed or does not exist";
    static ERROR_500 =
        "Internal Server Error - The server system is having problems or cannot be accessed.";
  };

  static AlertMessageVi = class {
    static SUCCESS_CREATED = "Thêm mới sản phẩm thành công !";
    static SUCCESS_UPDATED = "Cập nhật sản phẩm thành công !";
    static SUCCESS_DEACTIVATE = "Hủy sản phẩm thành công !";

    static ERROR_400 =
        "Thao tác không thành công, vui lòng kiểm tra lại dữ liệu.";
    static ERROR_401 =
        "Unauthorized - Access Token của bạn hết hạn hoặc không hợp lệ.";
    static ERROR_403 =
        "Forbidden - Bạn không được quyền truy cập tài nguyên này.";
    static ERROR_404 =
        "Not Found - Tài nguyên này đã bị xóa hoặc không tồn tại";
    static ERROR_500 =
        "Internal Server Error - Hệ thống Server đang có vấn đề hoặc không truy cập được.";

  };

  static SweetAlert = class {
    static showAlertSuccess(t) {
      Swal.fire({
        position: "top-end",
        icon: "success",
        title: t,
        showConfirmButton: false,
        timer: 1500,
      });
    }

    static showAlertError(t) {
      Swal.fire({
        position: "center",
        icon: "error",
        title: t,
        showConfirmButton: true,
      });
    }

    static showSuspendedConfirmDialog() {
      return Swal.fire({
        icon: "warning",
        text: "Bạn có chắc muốn xóa sản phẩm này không?",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Có, tôi muốn xóa sản phẩm này !",
        cancelButtonText: "Hoàn tác",
      });
    }
  };

  static IziToast = class {
    static showSuccessAlert(m) {
      iziToast.success({
        title: 'OK',
        position: 'topRight',
        timeout: 2500,
        message: m
      });
    }

    static showErrorAlert(m) {
      iziToast.error({
        title: 'Error',
        position: 'topRight',
        timeout: 2500,
        message: m
      });
    }
  }

  static renderRowProduct(product) {
    let str = `
                                <tr id="tr_${product.id}">
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>
                                       <img src="${product.image}" width="120px" height="auto"/>
                                    </td>
                                    <td>${product.quantity}</td>
                                    <td>${new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(product.price)}
                                    </td>
                                    <td>${product.category.name}</td>
                                    <td>
                                <button type="button" class="btn btn-outline-primary update" data-id="${product.id}"
                                    data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Edit">
                                    <i class="fas fa-edit"></i>
                                </button>
                                <button type="button" class="btn btn-outline-danger block" data-id="${product.id}"
                                    data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Delete">
                                    <i class="fas fa-minus"></i>
                                </button>
                            </td>
                                </tr>
                                `;
    return str;
  }

  static renderProduct(product) {
    let str = `
                                <tr id="tr_${product.id}">
                                    <td>${product.id}</td>
                                    <td>${product.name}</td>
                                    <td>
                                       <img src="${product.image}" width="120px" height="auto"/>
                                    </td>
                                    <td>${product.quantity}</td>
                                    <td>${new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(product.price)}
                                    </td>
                                    <td>${product.category.name}</td>
                                    <td>
                                <button type="button" class="btn btn-outline-success add_cart" data-id="${product.id}"
                                    data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="">
                                    <i class="fas fa-cart-plus"></i>
                                </button>
                            </td>
                                </tr>
                                `;
    return str;
  }


  static renderRowUser(user) {
    let str = `
                                <tr id="tr_${user.id}">
                                    <td>${user.id}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.username}</td>
                                    <td>${user.role.code}</td>
                                    <td>
                                <button type="button" class="btn btn-outline-primary update" data-id="${user.id}"
                                    data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Edit">
                                    <i class="fas fa-edit"></i>
<!--                                </button>-->
<!--                                <button type="button" class="btn btn-outline-danger block" data-id="${user.id}"-->
<!--                                    data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Block">-->
<!--                                    <i class="fas fa-minus"></i>-->
<!--                                </button>-->
                            </td>
                                </tr>
                                `;
    return str;
  }
}


  class Category {
    constructor(id, category) {
      this.id = id;
      this.name = category;
    }
  }

    class Product {
    constructor(id, name, image, quantity, price, category, isDeleted) {
      this.id = id;
      this.name = name;
      this.image = image;
      this.quantity = quantity;
      this.price = price;
      this.category = category;
      this.isDeleted = isDeleted;
    }
  }

class User {
  constructor(id, phone, username, password, role) {
    this.id = id;
    this.phone = phone;
    this.username = username;
    this.password = password;
    this.role = role;
  }
}

class Role {
  constructor(id, code) {
    this.id = id;
    this.code = code;
  }
}

