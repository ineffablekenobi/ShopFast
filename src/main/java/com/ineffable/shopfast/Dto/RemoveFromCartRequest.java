package com.ineffable.shopfast.Dto;

public class RemoveFromCartRequest {
    private Long userId;
    private Long productId;

    public RemoveFromCartRequest(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public RemoveFromCartRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
